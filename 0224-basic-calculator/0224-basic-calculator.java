class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int sign = 1;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If '+' or '-' is found
            else if (ch == '+' || ch == '-') {
                result += sign * num;
                num = 0;

                sign = (ch == '+') ? 1 : -1;
            }

            // Save result and sign before '('
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            // Calculate expression inside parentheses
            else if (ch == ')') {
                result += sign * num;
                num = 0;

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        // Add the last number
        result += sign * num;

        return result;
    }
}