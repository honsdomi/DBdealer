CREATE OR REPLACE FUNCTION check_capacity() RETURNS TRIGGER AS '
BEGIN
  IF ((SELECT COUNT(pobocka_id) AS Capacity_num FROM auto
    WHERE new.pobocka_id = auto.pobocka_id
    AND new.typ_karoserie = auto.typ_karoserie)< (SELECT hodnota FROM kapacita WHERE pobocka_id = new.pobocka_id AND typ_karoserie = new.typ_karoserie))
 THEN RETURN NEW;
END IF;
RETURN NULL;
END;  ' LANGUAGE 'plpgsql';

CREATE TRIGGER check_capacity BEFORE INSERT ON auto FOR EACH ROW EXECUTE PROCEDURE check_capacity();