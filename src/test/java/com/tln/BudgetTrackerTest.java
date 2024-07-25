package com.tln;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BudgetTrackerTest {

    BudgetTracker budgetTracker;

    @BeforeEach
    void setUp() {budgetTracker = new BudgetTracker();
    }

    @Test
    public void testAddTransaction() {
        budgetTracker.addTransaction("Payment",10);
        assertThat(budgetTracker.getTransactions()).hasSize(1);
        assertThat(budgetTracker.getBalance()).isEqualTo(10);
    }

    @Test
    public void testDeleteTransaction() {
        budgetTracker.addTransaction("Payout", 20);
        int id = budgetTracker.getTransactions().get(0).getId();
        budgetTracker.deleteTransaction(id);
        assertThat(budgetTracker.getTransactions()).isEmpty();
        assertThat(budgetTracker.getBalance()).isEqualTo(0.0);
    }

    @Test
    public void testUpdateTransaction() {
        budgetTracker.addTransaction("Salary", 1000.0);
        int id = budgetTracker.getTransactions().get(0).getId();
        budgetTracker.updateTransaction(id, "Bonus", 500.0);
        assertThat(budgetTracker.getTransactions()).hasSize(1);
        assertThat(budgetTracker.getBalance()).isEqualTo(500.0);
        assertThat(budgetTracker.getTransactions().get(0).getDescription()).isEqualTo("Bonus");
    }

    @Test
    public void testViewBalance() {
        budgetTracker.addTransaction("Salary", 1000.0);
        budgetTracker.addTransaction("Grocery", -200.0);
        assertThat(budgetTracker.getBalance()).isEqualTo(800.0);
        assertThat(budgetTracker.getTransactions().get(0).getDescription()).isEqualTo("Salary");
    }

   @Test
    public void testEmptyTransactionList() {
       assertThat(budgetTracker.getTransactions()).isEmpty();
   }
}


