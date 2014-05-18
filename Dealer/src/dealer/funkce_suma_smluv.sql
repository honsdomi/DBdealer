CREATE OR REPLACE FUNCTION prodalAut(varchar) RETURNS int AS '
DECLARE
ret	int;
BEGIN
ret = (SELECT sum(cena) FROM smlouva WHERE prodejce_id=(Select id FROM prodejce where jmeno =$1) 
        AND je_zaplacena=true);
IF ret IS NULL THEN 
    ret=0;
END IF;
RETURN ret;
END; ' LANGUAGE 'plpgsql' ;
