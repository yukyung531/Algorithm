-- 코드를 작성해주세요
SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
NATURAL JOIN FISH_NAME_INFO B
WHERE (A.FISH_TYPE, A.LENGTH) IN (
    SELECT DISTINCT FISH_TYPE, MAX(LENGTH) OVER(PARTITION BY FISH_TYPE)
    FROM FISH_INFO)
ORDER BY A.ID;