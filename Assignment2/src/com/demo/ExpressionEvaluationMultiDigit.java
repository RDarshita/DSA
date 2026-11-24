package com.demo;

import java.util.Arrays;

public class ExpressionEvaluationMultiDigit {
	public static int evaluatePostfix(String postfix) {
		int st[] = new int[10];
		String str[] = postfix.split(" ");
		int top = -1;
		for(int i=0;i<str.length;i++) {
			String element = str[i];
			if(!isOperator(element)) {
				int ele = Integer.parseInt(element);
				st[++top] = ele;
			}else {
				int op2 = st[top--];
				int op1 = st[top--];
				int result = calculate(op1,element.charAt(0),op2);
				st[++top] = result;
			}
		}
		return st[top];
	}
	
	public static boolean isOperator(String element) {
		if(element.length() != 1) {
			return false;
		}
		
		char ch = element.charAt(0);
		return ch == '*' || ch =='+' || ch=='-' || ch=='/' || ch=='%';
	}

	public static int calculate(int op1, char element, int op2) {
		switch(element){
		case '+': return op1+op2;
		case '-': return op1-op2;
		case '*': return op1*op2;
		case '/': return op1/op2;
		case '%': return op1%op2;
		}
		return 0;
	}

	public static void main(String[] args) {
		String postfix = "10 20 + 3 *";
		int result = evaluatePostfix(postfix);
		System.out.println("Postfix : " + result);
	}

}
