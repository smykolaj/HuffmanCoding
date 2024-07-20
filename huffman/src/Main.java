import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main
{
    public static void main(String[] args)
    {

        String input = "AABCCCDDEEEFFFFFFFFFFFFGGG";
        HashMap<Character, Integer> frequencies = calcFrequencies(input);
        Node finNode = createQueue(frequencies);
        printResults(finNode, "");
    }

    private static void printResults(Node node, String prefixCode)
    {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.letter.charAt(0) + ": " + prefixCode);
        }
        printResults(node.left, prefixCode + '1');
        printResults(node.right, prefixCode + '0');
    }

    private static Node createQueue(HashMap<Character, Integer> frequencies)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Character c : frequencies.keySet())
        {
            pq.add(new Node(frequencies.get(c), c.toString()));
        }
        while (pq.size() > 1)
        {
            Node s1 = pq.poll();
            Node s2 = pq.poll();
            Node s_new = new Node(s1.frequency+ s2.frequency, s1, s2);
            pq.add(s_new);
        }

        return pq.poll();

    }

    private static HashMap<Character, Integer> calcFrequencies(String input)
    {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (char c : input.toCharArray())
        {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    


}
