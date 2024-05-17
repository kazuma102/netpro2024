


public class DinnerFullCource {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public static void main(String[] args) {
        DinnerFullCource fullcourse = new DinnerFullCource();
        fullcourse.eatAll();
    }

    DinnerFullCource() {
		list[0] = new Dish();
		list[0].setName("白米");
		list[0].setValune(100);

		list[1] = new Dish();
		list[1].setName("納豆");
		list[1].setValune(50);

		list[2] = new Dish();
		list[2].setName("きんぴら");
		list[2].setValune(30);

		list[3] = new Dish();
		list[3].setName("焼き鮭");
		list[3].setValune(300);

		list[4] = new Dish();
		list[4].setName("味噌汁");
		list[4].setValune(100);
	}

    void eatAll() {
		String menu = "";
		int value = 0;

		for (Dish d : list) {
			menu += d.getName() + ",";
			value += d.getValune();
		}

		System.out.println("menu：" + menu + 
		"\nvalue：" + value + "円");
    }
}
