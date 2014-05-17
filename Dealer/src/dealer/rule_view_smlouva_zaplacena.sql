CREATE OR REPLACE RULE "zmena_smlouvy" AS
ON UPDATE TO pokus DO INSTEAD
UPDATE "smlouva"
SET "je_zaplacena" = NEW.je_zaplacena
WHERE NEW.id = id;