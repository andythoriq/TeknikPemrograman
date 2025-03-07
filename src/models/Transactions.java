package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transactions {
    private List<Income> incomeList;
    private List<Outcome> outcomeList;

    public Transactions() {
        this.incomeList = new ArrayList<>();
        this.outcomeList = new ArrayList<>();
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public List<Outcome> getOutcomeList() {
        return outcomeList;
    }

    public Income findIncomeById(String idTarget) {
        for (Income income : incomeList) {
            if (Objects.equals(income.getId(), idTarget)) {
                return income;
            }
        }
        return null;
    }

    public Outcome findOutcomeById(String idTarget) {
        for (Outcome outcome : outcomeList) {
            if (Objects.equals(outcome.getId(), idTarget)) {
                return outcome;
            }
        }
        return null;
    }

    // polimorfisme
    public void add(Income income) {
        incomeList.add(income);
        System.out.println("✅ Income berhasil ditambahkan: " + income);
    }

    // polimorfisme
    public void add(Outcome outcome) {
        outcomeList.add(outcome);
        System.out.println("✅ Outcome berhasil ditambahkan: " + outcome);
    }

    // polimorfisme
    public boolean edit(Income income, String date, double amount, String category) {
        if (income != null) {
            income.setDate(date);
            income.setAmount(amount);
            income.setCategory(category);

            System.out.println("✅ Income berhasil diperbarui: " + income);
            return true;
        }
        System.out.println("❌ Income tidak ditemukan.");
        return false;
    }

    // polimorfisme
    public boolean edit(Outcome outcome, String date, double amount, String category) {
        if (outcome != null) {
            outcome.setDate(date);
            outcome.setAmount(amount);
            outcome.setCategory(category);

            System.out.println("✅ Income berhasil diperbarui: " + outcome);
            return true;
        }
        System.out.println("❌ Income tidak ditemukan.");
        return false;
    }

    // polimorfisme
    public boolean remove(Income income) {
        if (income != null) {
            incomeList.remove(income);
            System.out.println("✅ Income berhasil dihapus.");
            return true;
        }
        System.out.println("❌ Income tidak ditemukan.");
        return false;
    }

    // polimorfisme
    public boolean remove(Outcome outcome) {
        if (outcome != null) {
            outcomeList.remove(outcome);
            System.out.println("✅ Outcome berhasil dihapus.");
            return true;
        }
        System.out.println("❌ Outcome tidak ditemukan.");
        return false;
    }
}
