package intern;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task4
{
   
    public static double fetchExchangeRate(String baseCurrency, String targetCurrency) throws IOException
    {
        String apiKey = "YOUR_API_KEY";
        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) 
        {
            response.append(line);
        }
        reader.close();

      
        String jsonResponse = response.toString();
        double exchangeRate = parseExchangeRate(jsonResponse, targetCurrency);

        return exchangeRate;
    }

   
    public static double parseExchangeRate(String jsonResponse, String targetCurrency) 
    {
        
        String[] parts = jsonResponse.split("\"" + targetCurrency + "\":");
        if (parts.length > 1) 
        {
            String valueStr = parts[1].split(",")[0];
            return Double.parseDouble(valueStr);
        }
        else
        {
            System.out.println("Exchange rate for target currency not found in response.");
            return -1; 
        }
    }

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

           
            System.out.print("Enter the base currency: ");
            String baseCurrency = reader.readLine().toUpperCase();

            // Input target currency
            System.out.print("Enter the target currency: ");
            String targetCurrency = reader.readLine().toUpperCase();

        
            System.out.print("Enter the amount to convert: ");
            double amount = Double.parseDouble(reader.readLine());

           
            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

            if (exchangeRate != -1) 
            {
              
                double convertedAmount = amount * exchangeRate;

               
                System.out.printf("%.2f %s equals %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            }
        } 
        catch (IOException | NumberFormatException e) 
        {
            e.printStackTrace();
        }
    }
}

