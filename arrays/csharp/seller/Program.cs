using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Entities;

class Program
{
    static Seller FindMaxSellerAmount(List<Seller> sellers) {
        double maxAmount = 0;
        Seller maxSeller = null;

        foreach (Seller seller in sellers) {
            if (seller.Amount > maxAmount) {
                maxAmount = seller.Amount;
                maxSeller = seller;
            }
        }

        return maxSeller;
    }

    static void Main() {
        string json = File.ReadAllText("file.json"); // incluir caminho do arquivo
        List<Seller> sellers = JsonConvert.DeserializeObject<List<Seller>>(json);

        Seller maxSeller = FindMaxSellerAmount(sellers);
        Console.WriteLine(maxSeller);
    }
}