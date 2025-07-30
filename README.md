# 👾 SW 접속자 정보 통계 API 구축 (연습 프로젝트)

## SpringBoot 구축, API 개발, SQL 작성

**[API 문서 초안]** [`SW 활용 현황 API (초안)`](https://github.com/HongDay/Comento_loginAPI_Project/blob/API_first/SW_API_draft.pdf)


1. 관련내용 학습
   - RestController / ResponseEntity
   - AJAX
2. Spring Boot 개발환경
   - GROUP : com.demo
   - Artifact : comentoStatistic
   - name : statistic
   - packages : jar
   - java : 17
   - Project : Maven
   - Depdnencies : lombok, Spring web, spring boot devTools
3. SW활용 현황 통계 API 구축을 위한 SQL
- 월별 접속자 수
  ```sql
   SELECT
    LEFT(ri.create_date, 4) AS yearMonth, COUNT(DISTINCT user_id) AS totcnt
   FROM request_info AS ri
   GROUP BY LEFT(ri.create_date, 4)
   ORDER BY yearMonth;
  ```
- 일자별 접속자 수
   ```sql
   SELECT
    LEFT(ri.create_date, 6) AS ddate, COUNT(DISTINCT user_id) AS totcnt
   FROM request_info AS ri
   GROUP BY LEFT(ri.create_date, 6)
   ORDER BY ddate;
   ```
- 평균 하루 로그인 수
   ```sql
   SELECT ROUND(AVG(day_count),2) AS dayAvg
   FROM (
   SELECT
   LEFT(ri.create_date, 6) AS ddate,
   COUNT(*) AS day_count
   FROM request_info AS ri
   GROUP BY LEFT(ri.create_date, 6)
   );
   ```
   ```sql
   SELECT
   ROUND(COUNT(*) / COUNT(DISTINCT LEFT(ri.create_date, 6)), 2) AS dayAvg
   FROM request_info;
   ```
- 휴일을 제외한 로그인 수
   ```sql
   /* 휴일 테이블 */
   CREATE TABLE holidays (
   holiday_date DATE PRIMARY KEY,
   holiday_name VARCHAR(50)
   );
   
   SELECT COUNT(*)
   FROM request_info
   WHERE create_date NOT IN (SELECT holiday_date FROM holidays);
   ```
- 부서별 월별 로그인 수
   ```sql
   SELECT
    u.hr_organ,
    LEFT(r.create_date, 4) AS login_month,
    COUNT(*) AS totcnt
   FROM request_info r
   JOIN user u ON r.user_id = u.user_id
   GROUP BY u.hr_organ, LEFT(r.create_date, 4)
   ORDER BY u.hr_organ, login_month;
   ```
- 일자별 접속자 수 (시작일자와 종료일자 지정, 접속사 없는 날짜 포함)
   ```sql
   SET @start_date = '2024-04-01';
   SET @end_date = '2024-04-07';
   // 이 값들은 Mapper.xml에서는 파라미터로 #{} 형식으로 넘겨받을 예정
   
   SELECT
       ri.create_date AS login_date,
       COUNT(DISTINCT ri.user_id) AS user_count
   FROM request_info AS ri
   WHERE ri.create_date BETWEEN @start_date AND @end_date
   GROUP BY ri.create_date
   ORDER BY ri.create_date;
   // 이방법은 로그인 기록이 없는 날짜는 아예 결과에 포함되지 않음
   
   WITH RECURSIVE date_sequence AS (
       SELECT @start_date AS dt
       UNION ALL // 재귀적으로 합침. (중복된 행 포함이면 ALL임. 근데 차피 하루씩 증가라 중복이 없으니깐 그냥 체크안하기 위해 ALL 붙임)
       SELECT DATE_ADD(dt, INTERVAL 1 DAY) // 날짜를 하루씩 증가하기
       FROM date_sequence // 바로 위에서 만든 자기자신 임시테이블을 바로 참조 (재귀)
       WHERE dt < @end_date  // 종료일보다 작을떄까지만 재귀 반복
   )
   
   SELECT
       ds.dt AS login_date,
       COUNT(DISTINCT ri.user_id) AS user_count
   FROM date_sequence as ds
   LEFT JOIN request_info ri ON ri.createdate = ds.dt // ds에있는 날짜는 일단 다반영
   GROUP BY ds.dt
   ORDER BY ds.dt;
   ```
  WITH는 임시테이블 (CTE)를 만드는 구문, RECURSIVE는 자기 자신 테이블을 재귀적으로 호출해서 사용하고 싶을 때 사용.
  UNION은 두개 이상의 SELECT 결과를 합치는 것임.