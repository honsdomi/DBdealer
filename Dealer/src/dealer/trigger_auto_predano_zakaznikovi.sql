CREATE OR REPLACE FUNCTION auto_predano() RETURNS TRIGGER AS '
BEGIN
  UPDATE auto SET pobocka_id = NULL WHERE vin = (SELECT auto_vin FROM rezervace WHERE old.rezervace_id = id);
  RETURN NEW;
END;  ' LANGUAGE 'plpgsql';

CREATE TRIGGER predej_auto AFTER UPDATE ON smlouva FOR EACH ROW EXECUTE PROCEDURE auto_predano();
