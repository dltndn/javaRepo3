package repo3;

import java.util.*;

class Shopping {
  
  LinkedList<Cart> carts = new LinkedList<Cart>();
  int cartsSize = carts.size();
  
  void shoppingMenu() {
	  
    while (true) {
    	Scanner sc = new Scanner(System.in);    	
      System.out.println("1.카트 임대");
      System.out.println("2.카트 반납");
      System.out.println("3.쇼핑 종료");

      System.out.print("동작 입력: ");
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
    System.out.println("카트 대여 메뉴");
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
    System.out.println("카트 반납 메뉴");
    System.out.print("type ur name: ");
    String s = sc.nextLine();
    if (cartsSize == 0) {
    	System.out.println("카트가 비어있습니다.");
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
      System.out.println("1. 카트에 상품 추가");
      System.out.println("2. 카트에 수량 추가");
      System.out.println("3. 카트 상품 제거");
      System.out.println("4. 카트 상품 출력");
      System.out.println("5. 카트관련 동작 종료");
      System.out.print("카트동작 입력: ");
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
    System.out.println("상품 추가 메뉴");
    System.out.print("상품 이름: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      addItem(name);
      return;
    }
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      s = it.getGoodsName();
      if (name == s) {
        System.out.print("추가할 수량: ");
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
    System.out.println("상품 수량 변경 메뉴");
    System.out.print("상품 이름: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      System.out.println("카트에 상품이 없습니다.");
      return;
    } 
    for (int i=0; i<itemsSize; i++) {
      it = items.get(i);
      s = it.getGoodsName();
      if (name == s) {
        System.out.println("변경할 수량: ");
        int a = sc2.nextInt();
        it.setAmmount(a);
        return;
      }
    }
    System.out.println("입력하신 상품이 없습니다.");
  }

  void removeCart() {
    Item it;
    String s;
    System.out.println("상품 제거 메뉴");
    System.out.print("상품 이름: ");
    String name = sc2.nextLine();
    if (itemsSize == 0) {
      System.out.println("카트에 상품이 없습니다.");
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
    System.out.println("입력하신 상품이 없습니다.");
   }
  
  void printItems() {
    Item it;
    String name;
    int amm;
    int price;
    if (itemsSize == 0) {
      System.out.println("카트에 상품이 없습니다.");
      return;
    } 
    System.out.println("상품명    수량    가격");
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
      System.out.println("카트에 상품이 없습니다.");
      return;
    } 
    for (int i=0; i<itemsSize; i++) {
      it = items.remove(i);
      System.out.println("상품 제거 완료");
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
