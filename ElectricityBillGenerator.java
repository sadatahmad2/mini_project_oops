import java.util.Scanner;

class Customer {
    private String consumerId, name, address, meterNumber;

    public Customer(String consumerId, String name, String address, String meterNumber) {
        this.consumerId = consumerId;
        this.name = name;
        this.address = address;
        this.meterNumber = meterNumber;
    }
    public String getConsumerId() { return consumerId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getMeterNumber() { return meterNumber; }
}

class TariffSlab {
    private double rate = 6.00;

    public TariffSlab() {}
    public TariffSlab(double rate) {
        if (rate > 0) this.rate = rate;
    }

    public double calculateEnergyCharge(int units) {
        return units * rate;
    }
}

class Bill {
    protected Customer customer;
    protected int unitsConsumed;
    protected double unitRate = 6.00;
    protected double energyCharge, fixedCharge, totalAmount;

    public Bill(Customer customer, int unitsConsumed) {
        this.customer = customer;
        this.unitsConsumed = unitsConsumed;
    }
    public Bill(Customer customer, int unitsConsumed, double unitRate) {
        this.customer = customer;
        this.unitsConsumed = unitsConsumed;
        if (unitRate > 0) this.unitRate = unitRate;
    }
    public void calculateBill() {
        energyCharge = new TariffSlab(unitRate).calculateEnergyCharge(unitsConsumed);
        fixedCharge = 50.00;
        totalAmount = energyCharge + fixedCharge;
    }
    public void displayBill() {
        System.out.println("\n========== ELECTRICITY BILL ==========");
        System.out.println("Consumer ID   : " + customer.getConsumerId());
        System.out.println("Name          : " + customer.getName());
        System.out.println("Address       : " + customer.getAddress());
        System.out.println("Meter Number  : " + customer.getMeterNumber());
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.printf("Energy Charge : Rs. %.2f%n", energyCharge);
        System.out.printf("Fixed Charge  : Rs. %.2f%n", fixedCharge);
        System.out.printf("Total Amount  : Rs. %.2f%n", totalAmount);
        System.out.println("======================================");
    }
}

class DomesticBill extends Bill {
    public DomesticBill(Customer customer, int unitsConsumed) {
        super(customer, unitsConsumed);
    }
    public DomesticBill(Customer customer, int unitsConsumed, double unitRate) {
        super(customer, unitsConsumed, unitRate);
    }
    @Override
    public void calculateBill() {
        super.calculateBill();
    }
}

public class ElectricityBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== ELECTRICITY BILL GENERATOR =====");
        System.out.print("Enter Consumer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Meter Number: ");
        String meter = sc.nextLine();
        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        if (units < 0) {
            System.out.println("Invalid input: units cannot be negative.");
            sc.close();
            return;
        }

        Customer customer = new Customer(id, name, address, meter);
        DomesticBill bill = new DomesticBill(customer, units);
        bill.calculateBill();
        bill.displayBill();
        sc.close();
    }
}
