package com.wision.controller.test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class Calculator implements ActionListener{
	private final JFrame f;
	private final JPanel mp;
	//定义两个文本框用来显示算式和结果
	private final JTextField show, showed;
	//定义数字、控制、运算符号按钮
	private final Map<String, JButton> b = new HashMap<>();//buttons
	//定义算式的字符串表示
	private String exp, outcome;
	private final Color fontColor = Color.BLACK;
	private final Font theDefaultFont = new Font(Font.SERIF, Font.BOLD, 25);

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.display();
	}

	//在构造函数中初始化控件和变量
	private Calculator() {
		f = new JFrame("计算器");
		mp = new JPanel();
		show = new JTextField("0");//创建单行文本控件
		showed = new JTextField();
		String[] keys = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "C", "DEL", "+", "-", "*", "/", "+/-", ".", "="};
		for (String key : keys) {
			b.put(key, new JButton(key));
		}
		exp = outcome = "";//初始设置存储算式和结果的字符串为空串
	}

	public void display() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭就退出程序
		//设置显示结果的单行文本框相关属性
		show.setFont(new Font(Font.SERIF, Font.BOLD, 40));//设置字体样式
		show.setBorder(BorderFactory.createEmptyBorder());//设置单行文本控件无边框
		show.setHorizontalAlignment(SwingConstants.RIGHT);//设置文本靠右显示
		show.setEnabled(false);//设置单行文本框不能点击
		showed.setFont(theDefaultFont);
		showed.setBorder(BorderFactory.createEmptyBorder());
		showed.setHorizontalAlignment(SwingConstants.RIGHT);
		showed.setEnabled(false);
		//设置按钮为透明
		Calculator calculator = this;
		b.forEach((k, v) -> {
			v.setFont(theDefaultFont);
			v.setForeground(fontColor);
			if ("=".equals(k)) {
				b.get("=").setBackground(Color.CYAN);
				v.setContentAreaFilled(true);
			} else {
				v.setContentAreaFilled(false);
			}
			v.addActionListener(calculator);
		});
		GridBagLayout layout = new GridBagLayout();
		mp.setLayout(layout);
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;//设置当某个单元格未填满时填满整个空间
		g.weightx = 1.0;//设置窗口变大时缩放比例
		g.weighty = 1.0;
		g.gridx = 0;//定位在第一行第一列
		g.gridy = 0;
		g.gridwidth = GridBagConstraints.REMAINDER;//填满整行
		g.gridheight = 1;//占一行网格
		g.insets = new Insets(5, 5, 0, 5);//设置该组件与其它组件的距离
		layout.setConstraints(showed, g);//将上述
		g.gridx = 0;
		g.gridy = 1;
		g.gridheight = 2;
		g.insets = new Insets(0, 5, 5, 5);
		layout.setConstraints(show, g);
		g.insets = new Insets(5, 5, 5, 5);
		g.gridwidth = 1;
		g.gridheight = 1;
		//按钮大概位置
		setButtonPosition(layout, 3, g, b.get("CE"), b.get("C"), b.get("DEL"), b.get("/"));
		setButtonPosition(layout, 4, g, b.get("7"), b.get("8"), b.get("9"), b.get("*"));
		setButtonPosition(layout, 5, g, b.get("4"), b.get("5"), b.get("6"), b.get("-"));
		setButtonPosition(layout, 6, g, b.get("1"), b.get("2"), b.get("3"), b.get("+"));
		setButtonPosition(layout, 7, g, b.get("+/-"), b.get("0"), b.get("."), b.get("="));
		b.forEach((k, v) -> mp.add(v));
		mp.add(showed);
		mp.add(show);
		f.setContentPane(mp);
		f.setSize(440, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private void setButtonPosition(GridBagLayout layout, int grIdy, GridBagConstraints constraint, JButton but0, JButton but1, JButton but2, JButton but3) {
		constraint.gridy = grIdy;
		constraint.gridx = 0;
		layout.setConstraints(but0, constraint);
		constraint.gridx = 1;
		layout.setConstraints(but1, constraint);
		constraint.gridx = 2;
		layout.setConstraints(but2, constraint);
		constraint.gridx = 3;
		layout.setConstraints(but3, constraint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		outcome = "";
		if ((e.getSource()) == b.get("CE")) {//清除最后一个输入的操作数
			int pos = posOfLastOperator(exp);//获取最后一个运算符的位置
			if (pos >= 0)
				exp = exp.substring(0, pos + 1);
			else//只有一个操作数直接清空
				exp = "0";
			show.setText(exp);
		} else if ((e.getSource()) == b.get("C")) {//清空算式
			exp = "0";
			show.setText(exp);
		} else if ((e.getSource()) == b.get("del")) {
			//提取字符串开始到倒数第二个字符
			exp = exp.substring(0, exp.length() - 1);
			if (exp.length() == 0)//删除全部的输入后设置显示0
				exp = "0";
			show.setText(exp);
		} else if ((e.getSource()) == b.get("+") || (e.getSource()) == b.get("minus") || (e.getSource()) == b.get("mul") || (e.getSource()) == b.get("div")) {
			if (exp.length() != 0 && (!isOperator(exp.charAt(exp.length() - 1))))//确认必须有数字才能输入运算符
				exp += e.getActionCommand();
			show.setText(exp);
		} else if ((e.getSource()) == b.get("neg")) {
			int pos = posOfLastOperator(exp);
			if (pos >= 0) {//算符中存在多个操作数
				if (isDigit(exp.charAt(exp.length() - 1)))//只有有数字才能置为负数
					exp = exp.substring(0, pos + 1) + "(-" + exp.substring(pos + 1) + ")";//设置为负数时加上括号以区分与减号
			} else {//只有一个操作数
				if (!Objects.equals(exp, "") && isDigit(exp.charAt(exp.length() - 1)))
					exp = "-" + exp;
			}
			if (exp.equals(""))//设置当算式为空时显示0
				exp = "0";
			show.setText(exp);
		} else if ((e.getSource()) == b.get("=")) {
			exp += '#';//算式末尾添加’#’
			//从算式中拆分出数字
			String[] nums = exp.split("[^.0-9]");
			List<Double> numLst = new ArrayList<>();
			for (String num : nums) {//将每个数字串转化为Double类型
				if (!"".equals(num))
					numLst.add(Double.parseDouble(num));
			}
			double out = getValueOfMid(exp, numLst);//利用中缀式求值
			outcome = "" + out;//将求得的结果转为字符串
			exp = exp.substring(0, exp.length() - 1);//去除算式后的’#’
			showed.setText(exp);//第一个单行文本框展示算式
			show.setText(new BigDecimal(outcome).stripTrailingZeros().toPlainString());//第二个单行文本框显示结果
			exp = "";//存储算式的字符串清空
		} else if ((e.getSource()) == b.get("point")) {
			int pos = exp.lastIndexOf('.');//找到最后一个小数点的位置
			if (pos >= 0) {//前后两个小数点间不能都是数字，即不能2.33时又添加一个小数点变为2.33.
				if (isDigit(exp.charAt(exp.length() - 1)) && !isDigitString(exp.substring(pos + 1)))
					exp += e.getActionCommand();
			} else {//小数点前一个必须是数字
				if (isDigit(exp.charAt(exp.length() - 1)))
					exp += e.getActionCommand();
			}
			show.setText(exp);
		} else {
			if (Objects.equals(exp, "0"))
				exp = "";
			exp += e.getActionCommand();
			show.setText(exp);
		}
	}

	public static boolean isDigit(char ch) {//判断一个字符是否为数字
		return (ch >= '0' && ch <= '9');
	}

	public boolean isDigitString(String s) {//判断一个字符是否都为数字
		for (int i = 0; i < s.length(); i++) {
			if (!isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	public boolean isOperator(char c) {//判断一个字符是否为运算符或’.’
		return (c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '.');
	}

	public int posOfLastOperator(String s) {//寻找字符串中最后一个运算符(+,-,*,/)的位置
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != '.' && isOperator(s.charAt(i)))
				return i;
		}
		return -1;//找不到返回-1
	}

	public static int isp(char ch) {//定义栈中运算符优先级，并将相应算符的优先级返回
		switch (ch) {
			case ')':
				return 4;
			case '*':
			case '/':
				return 3;
			case '+':
			case '-':
				return 2;
			case '(':
				return 1;
			case '#':
				return 0;
		}
		return -1;
	}

	public static int icp(char ch) {//定义栈外运算符优先级，并将相应算符的优先级返回
		switch (ch) {
			case ')':
				return 1;
			case '*':
			case '/':
				return 3;
			case '+':
			case '-':
				return 2;
			case '(':
				return 4;
			case '#':
				return 0;
		}
		return 0;
	}

	public static double compute(double a, char ch, double b) {//将取出的两个操作数与对应的算符进行计算并返回计算结果
		switch (ch) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				return a / b;
			default:
				break;
		}
		return 0;
	}

	//对输入的算式（中缀式）进行求值
	public static double getValueOfMid(String exp, List<Double> numLst) {
		Stack<Character> OPTR = new Stack<>();//定义算符栈
		Stack<Double> OPND = new Stack<>();//定义操作数栈
		double outcome;//最终结果
		double a, b;//定义两个操作数
		char sym;//定义运算符
		OPTR.push('#');
		int i = 0, j = 0;
		while (exp.charAt(i) != '#' || OPTR.peek() != '#') {
			if (isDigit(exp.charAt(i))) {//遍历到数字时则跳过数字字符串，并将之前划分的double类型数据代替压栈
				while (isDigit(exp.charAt(i)) || exp.charAt(i) == '.') {
					i++;
					if (i == exp.length())
						break;
				}
				i--;
				OPND.push(numLst.get(j));
				j++;
			} else {
				sym = OPTR.peek();
				int m = isp(sym);
				int n = icp(exp.charAt(i));
				if (m < n)//比较栈内和栈外运算符的优先级
					OPTR.push(exp.charAt(i));//栈内算符优先级小于栈外，则栈外运算符压栈
				else {//栈内运算符优先级大于栈外运算符优先级
					sym = OPTR.peek();
					OPTR.pop();//取出栈内的运算符
					if (sym != '(' && m == n || m > n) {
						b = OPND.peek();//从操作数栈取出一个操作数
						OPND.pop();
						if (!OPND.empty() && OPTR.peek() != '(') {//当操作数栈不为空且不为’(’时继续取出栈中的数进行运算
							a = OPND.peek();
							OPND.pop();
							OPND.push(compute(a, sym, b));
						} else {//处理负数
							switch (sym) {//实现一元运算符的运算
								case '+':
									OPND.push(b);
									break;
								case '-':
									OPND.push(-b);
									break;
							}
						}
						continue;
					}
				}
			}
			i++;
		}
		outcome = OPND.peek();
		return outcome;
	}
}