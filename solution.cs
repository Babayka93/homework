using System;

class Program
{
    static void Main()
    {
        string[] originalArray = { "один", "два", "три", "четыре", "пять", "шесть", "семь" };

        string[] newArray = new string[originalArray.Length];
        int newArrayIndex = 0;

        for (int i = 0; i < originalArray.Length; i++)
        {
            if (originalArray[i].Length <= 3)
            {
                newArray[newArrayIndex] = originalArray[i];
                newArrayIndex++;
            }
        }

        Console.WriteLine("Новый массив из строк, длина которых меньше или равна 3 символам:");

        Array.Resize(ref newArray, newArrayIndex); 

        foreach (string str in newArray)
        {
            Console.WriteLine(str);
        }
    }
}