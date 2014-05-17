CREATE OR REPLACE FUNCTION auto_prideleno_k_rezervaci() RETURNS TRIGGER AS '
BEGIN
  UPDATE rezervace SET auto_vin = new.vin
    WHERE  id = (SELECT id FROM rezervace WHERE rezervace.znacka = new.znacka 
    AND rezervace.model = new.model 
    and rezervace.barva = new.barva 
    and rezervace.rok_vyroby = new.rok_vyroby
    limit 1);
  RETURN NEW;
END;  ' LANGUAGE 'plpgsql';

CREATE TRIGGER auto_prideleno_k_rezervaci BEFORE INSERT ON auto FOR EACH ROW EXECUTE PROCEDURE auto_prideleno_k_rezervaci();