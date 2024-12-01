package Gamma_Scenario;

import java.util.Scanner;

interface PaymentGateway {
    void processPayment(double amount);
}

class PayPalAdapter implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via PayPal: $" + amount);
    }
}

class StripeAdapter implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Stripe: $" + amount);
    }
}

class SquareAdapter implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Square: $" + amount);
    }
}


class PaymentGatewayFactory {
    public static PaymentGateway getPaymentGateway(String provider) {
        return switch (provider.toLowerCase()) {
            case "paypal" -> new PayPalAdapter();
            case "stripe" -> new StripeAdapter();
            case "square" -> new SquareAdapter();
            default -> throw new IllegalArgumentException("Unsupported provider: " + provider);
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String provider = sc.nextLine();;
        double amount = sc.nextDouble();

        PaymentGateway gateway = PaymentGatewayFactory.getPaymentGateway(provider);
        gateway.processPayment(amount);
    }
}
