-- Hibernate 6 defaults GenerationType.AUTO id generators to a pooled optimizer
-- with allocationSize=50, and validates that against the real sequence's
-- INCREMENT BY at boot (hibernate.id.sequence.increment_size_mismatch_strategy
-- = EXCEPTION by default). All entities share IdEntity's AUTO strategy, so
-- every per-table sequence in this schema needs to move from INCREMENT BY 1
-- to INCREMENT BY 50 to match.
DO $$
DECLARE
    seq RECORD;
BEGIN
    FOR seq IN
        SELECT sequence_schema, sequence_name
        FROM information_schema.sequences
        WHERE sequence_schema = 'public'
    LOOP
        EXECUTE format('ALTER SEQUENCE %I.%I INCREMENT BY 50', seq.sequence_schema, seq.sequence_name);
    END LOOP;
END $$;
