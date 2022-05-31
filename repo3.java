package repo3;

import java.util.*;

class Shopping {
  
  LinkedList<Cart> carts = new LinkedList<Cart>();
  int cartsSize = carts.size();
  
  void shoppingMenu() {
	  
    while (true) {
    	Scanner sc = new Scanner(System.in);    	
      System.out.println("1.īƮ �Ӵ�");
      System.out.println("2.īƮ �ݳ�");
      System.out.println("3.���� ����");

      System.out.print("���� �Է�: ");
      int x = sc.nextInt();
      if (x == 1) {
        rentCart();
      } else if (x == 2) {
        returnCart();
      } else if (x == 3) {
        return;
      } else {
        System.out.println("type wrong");
      }
    	
    }
  }

  void rentCart() {
	  Scanner sc = new Scanner(System.in);
    System.out.println("īƮ �뿩 �޴�");
    System.out.println("type ur name: ");
    String s = sc.nextLine();
    Cart c = new Cart(s);
    carts.addFirst(c);
    carMenu(c, s);
  }

  void returnCart() {
	  Scanner sc = new Scanner(System.in);
    String x;
    Cart c;
    System.out.println("īƮ �ݳ� �޴�");
    System.out.print("type ur name: ");
    String s = sc.nextLine();
    if (cartsSize == 0) {
    	System.out.println("īƮ�� ����ֽ��ϴ�.");
    	return;
    }
    for (int i=0; i < cartsSize; i++) {
      c = carts.get(i);
      x = c.getUser();
      System.out.printf("%s  %s", s, x );
      if (s == x) {
        carts.remove(i);
        return;
      }
    }
    System.out.println("type wrong");    
  }

  void carMenu(Cart c, String s) {
    while (true) {
    	Scanner sc = new Scanner(System.in);
      System.out.println("1. īƮ�� ��ǰ �߰�");
      System.out.println("2. īƮ�� ���� �߰�");
      System.out.println("3. īƮ ��ǰ ����");
      System.out.println("4. īƮ ��ǰ ���");
      System.out.println("5. īƮ���� ���� ����");
      System.out.print("īƮ���� �Է�: ");
      int x = sc.nextInt();
      if (x == 5) return;
      cartAction(c, x);
    }
  }

  void cartAction(Cart c, int x) {
     switch (x) {
    case 1:
      c.addCart();
    case 2:
      c.updateCart();
    case 3:
      c.removeCart();
    case 4:
      c.printItems();
    case 5:
      return;
    }
  }
}

class Cart {
  Scanner sc2 = new Scanner(System.in);
  private String user;
  LinkedList<Item> items = new LinkedList<Item>();
  int itemsSize = items.size();
  
  public Cart(String s) {
    user = s;
  }

  public String getUser() {
	  return user;
  }

  void addCart() {
    Item it;
    String s;
    System.out.println("��ǰ �߰� �޴�");
    System.out.print("��ǰ �̸�: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      addItem(name);
      return;
    }
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      s = it.getGoodsName();
      if (name == s) {
        System.out.print("�߰��� ����: ");
        int b = sc2.nextInt();
        int a = it.getAmmount();
        it.setAmmount(a + b);
        return;
      }  
    }
    addItem(name);
  }

  void updateCart() {
    Item it;
    String s;
    System.out.println("��ǰ ���� ���� �޴�");
    System.out.print("��ǰ �̸�: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      System.out.println("īƮ�� ��ǰ�� �����ϴ�.");
      return;
    } 
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      s = it.getGoodsName();
      if (name == s) {
        System.out.println("������ ����: ");
        int a = sc2.nextInt();
        it.setAmmount(a);
        return;
      }
    }
    System.out.println("�Է��Ͻ� ��ǰ�� �����ϴ�.");
  }

  void removeCart() {
    Item it;
    String s;
    System.out.println("��ǰ ���� �޴�");
    System.out.print("��ǰ �̸�: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      System.out.println("īƮ�� ��ǰ�� �����ϴ�.");
      return;
    } 
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      s = it.getGoodsName();
      if (name == s) {
    	 items.remove(i);
        return;
      }
    }
    System.out.println("�Է��Ͻ� ��ǰ�� �����ϴ�.");
   }
  
  void printItems() {
    Item it;
    String name;
    int amm;
    int price;
    if (itemsSize == 0) {
      System.out.println("īƮ�� ��ǰ�� �����ϴ�.");
      return;
    } 
    System.out.println("��ǰ��    ����    ����");
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      name = it.getGoodsName();
      amm = it.getAmmount();
      price = it.getPrice();
      System.out.printf(name + "  " + amm + "    " + price + "\n");
    }
  }

  void emptyCart() {
    Item it;
    if (itemsSize == 0) {
      System.out.println("īƮ�� ��ǰ�� �����ϴ�.");
      return;
    } 
    for (int i=0; i<itemsSize; i++) {
      it = items.remove(i);
      System.out.println("��ǰ ���� �Ϸ�");
    }
  }
  
  void addItem(String s) {
      Item i = new Item(s);
      items.addFirst(i);
   }
}

class Item {
  private String goodsName;
  private int ammount;
  private int price;

  public Item(String x) {
    goodsName = x;
    ammount = 0;
    price = 1000;
  }

  public void setAmmount(int ammount) {
    this.ammount = ammount;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public int getAmmount() {
    return ammount;
  }

  public int getPrice() {
    return price;
  }
  
}

public class repo3 {

	public static void main(String[] args) {
		Shopping sh = new Shopping();
	    sh.shoppingMenu();
	}
}
