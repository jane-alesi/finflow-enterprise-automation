-- Test data for FinFlow Workflow Engine Integration Tests
-- This file contains sample data for testing database connectivity and operations

-- Note: This SQL is compatible with both PostgreSQL (TestContainers) and H2 (unit tests)

-- Create test tables if they don't exist (for basic connectivity testing)
CREATE TABLE IF NOT EXISTS test_workflow (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS test_transaction (
    id BIGSERIAL PRIMARY KEY,
    workflow_id BIGINT,
    amount DECIMAL(19,2) NOT NULL,
    currency VARCHAR(3) NOT NULL DEFAULT 'EUR',
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (workflow_id) REFERENCES test_workflow(id)
);

-- Insert sample test data
INSERT INTO test_workflow (name, status) VALUES 
    ('Test Workflow 1', 'ACTIVE'),
    ('Test Workflow 2', 'PENDING'),
    ('Test Workflow 3', 'COMPLETED');

INSERT INTO test_transaction (workflow_id, amount, currency, status) VALUES 
    (1, 1000.00, 'EUR', 'PENDING'),
    (1, 2500.50, 'USD', 'COMPLETED'),
    (2, 750.25, 'GBP', 'PENDING'),
    (3, 10000.00, 'EUR', 'COMPLETED');

-- Verify data insertion (these will be used in tests)
-- SELECT COUNT(*) FROM test_workflow; -- Should return 3
-- SELECT COUNT(*) FROM test_transaction; -- Should return 4