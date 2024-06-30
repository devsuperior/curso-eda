public class BuscaSequencial {
	public static <T extends Comparable<T>> int sequentialSearch(T[] array, T chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(chave) == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numeros = {28, 6, -2, 9, 16, 20, 23, 8};
        System.out.println(sequentialSearch(numeros, 20)); // 5

        Integer[] outrosNumeros = {4, 6, -3, 21, 55, 91, 2};
        System.out.println(sequentialSearch(outrosNumeros, 11)); // -1
    }
}
