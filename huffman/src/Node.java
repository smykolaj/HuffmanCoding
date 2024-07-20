public class Node implements Comparable<Node>
{
    int frequency;
    String letter;
    Node right;
    Node left;

    public Node(int frequency, String letter)
    {
        this.frequency = frequency;
        this.letter = letter;
    }

    public Node(int frequency, Node right, Node left)
    {
        this.frequency = frequency;
        this.right = right;
        this.left = left;
        this.letter = left.letter + right.letter;
    }


    public int compareTo(Node o) {
        if (this.frequency == o.frequency) {
            return Character.compare(smallest_alphabet(this.letter), smallest_alphabet(o.letter));
        }
        return this.frequency - o.frequency;
    }

    static char smallest_alphabet(String a) {
        char min = 'z';
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < min) {
                min = a.charAt(i);
            }
        }
        return min;
    }


}


