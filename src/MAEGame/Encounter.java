// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAEGame;

import java.util.Scanner;
// TODO: Auto-generated Javadoc

/**
 * *********************************************************.
 * 
 */

public class Encounter {

	/** The p. */
	public int p = 1;

	/** The level flag. */
	public boolean level_flag = false;

	/** The choicew. */
	public ChoiceW choicew;

	/** The flag 4. */
	public int flag4 = 0;

	/** The c. instance of class scanner */
	Scanner c = new Scanner(System.in);

	/** The choiced. */
	public ChoiceD choiced;

	/** The index rogue attack. */
	private int index_rogue_attack;

	/** The rogue attack. */
	private String rogue_attack = "ccccc";

	/** The rogue attack count. */
	private int rogue_attack_count = 0;

	/** The rogue attack flag. */
	private int rogue_attack_flag = 0;

	/**
	 * Instantiates a new encounter.
	 */
	public Encounter() {
		choicew = new ChoiceW();
		choiced = new ChoiceD();
	}

	/**
	 * Attack D. The use of switch cases allows us to add unique special features to
	 * each warriors This was not possible in until update 4
	 */
	public void attackD() {
		int a;
		if (choiced.getL_demon().isEmpty() == true) {
			level_flag = true;
			// System.out.println(level_flag);
			System.out.println("you cleared this round!! Warriors Won ");
		}
		for (int i = 0; i < choiced.getL_demon().size(); i++) {
			if (choiced.getL_demon().get(i).getHp() == 0) {
				// choiced.getL_demon_history_faint().add(choicew.getL_warrior().get(i));
				choiced.getL_demon().remove(i);
			}
		}
		for (int i = 0; i < choicew.getL_warrior().size(); i++) {
			if (choicew.getL_warrior().get(i).getHp() == 0) {
				choicew.getL_warrior_history_faint().add(choicew.getL_warrior().get(i));
				choicew.getL_warrior().remove(i);
			}
		}

		// Scanner c = new Scanner(System.in);
		System.out.println("Choose the warrior you want to attack demon with: ");
		a = c.nextInt();
		String war = choicew.getL_warrior().get(a - 1).getName();
		switch (war) {
		case "duelist":
			for (int j = 0; j < 2; j++) {
				attack_one_demon(a);
				for (int i = 0; i < choiced.getL_demon().size(); i++)
					System.out.println("D " + (i + 1) + ":" + choiced.getL_demon().get(i).getName() + "\t Strength="
							+ choiced.getL_demon().get(i).getAttack() + "\t HP=" + choiced.getL_demon().get(i).getHp()
							+ "/" + choiced.getL_demon().get(i).getMaxhp());
			}
			break;
		case "monk":
			attack_one_demon(a);
			break;
		case "rogue":
			attack_one_demon(a);
			break;
		case "slime":
			attack_one_demon(a);
			break;
		case "berserker":
			attack_one_demon(a);
			break;
		case "vishal":
			attack_one_demon(a);
			break;
		case "warrior":
			attack_one_demon(a);
			break;
		case "paladin":
			attack_one_demon(a);
			break;
		case "cleric":
			attack_one_demon(a);
			break;
		case "assassin":
			attack_one_demon(a);
			break;
		case "defender":
			attack_one_demon(a);
			break;
		default:
			System.out.println("Choose the correct warrior index:  ");
			break;
		}
		// for(int i=0; i<2; i++) {
		// if (choicew.getL_warrior().get(a-1).getName()=="duelist")

	}

	/**
	 * Attack one demon chosen by the warrior
	 *	
	 * @param a the a is the index of warrior that would attack the chosen demon
	 */
	public void attack_one_demon(int a) {
		int b;
		if (level_flag == false) {
			switch (a) {
			case 1:
				System.out.println("Choose the demon you want to attack: ");
				b = c.nextInt();
				// condition for rogue
				/*
				 * if (choicew.getL_warrior().get(a-1).getName()=="rogue") {
				 * choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
				 * }
				 */
				// condition for rogue
				if (choicew.getL_warrior().get(a - 1).getName() == "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					// choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
					index_rogue_attack = b;
					rogue_attack = choiced.getL_demon().get(b - 1).getName();
					rogue_attack_flag = 1;

				}
				// condition for berserker
				if (choicew.getL_warrior().get(a - 1).getName() == "berserker") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					if (choiced.getL_demon().get(b - 1).getHp() == 0)
						choiced.getL_demon().get(b - 1).setHp(5); // set monstor hp to 5
																	// after monster is fainted
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " got fainted"
							+ " by " + choicew.getL_warrior().get(a - 1).getName() + " !! hence gets 5 hp back ");
				}
				// choose_alive_warrior()
				else if (choicew.getL_warrior().get(a - 1).getName() != "berserker"
						&& choicew.getL_warrior().get(a - 1).getName() != "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
				}
				break;
			case 2:
				System.out.println("Choose the demon you want to attack: ");
				b = c.nextInt();
				/*
				 * //condition for rogue if (choicew.getL_warrior().get(a-1).getName()=="rogue")
				 * {
				 * choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
				 * }
				 */
				// condition for rogue
				if (choicew.getL_warrior().get(a - 1).getName() == "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					// choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
					index_rogue_attack = b;
					rogue_attack = choiced.getL_demon().get(b - 1).getName();
					rogue_attack_flag = 1;

				}
				// condition for berserker
				if (choicew.getL_warrior().get(a - 1).getName() == "berserker") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					if (choiced.getL_demon().get(b - 1).getHp() == 0)
						choiced.getL_demon().get(b - 1).setHp(5); // set monster hp to 5
																	// after monster is fainted
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " got fainted"
							+ " by " + choicew.getL_warrior().get(a - 1).getName() + " !! hence gets 5 hp back ");
				} else if (choicew.getL_warrior().get(a - 1).getName() != "berserker"
						&& choicew.getL_warrior().get(a - 1).getName() != "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
				}
				break;
			case 3:
				System.out.println("Choose the demon you want to attack: ");
				b = c.nextInt();
				// condition for rogue
				/*
				 * if (choicew.getL_warrior().get(a-1).getName()=="rogue") {
				 * choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
				 * }
				 */
				// condition for rogue
				if (choicew.getL_warrior().get(a - 1).getName() == "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					// choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
					index_rogue_attack = b;
					rogue_attack = choiced.getL_demon().get(b - 1).getName();
					rogue_attack_flag = 1;

				}
				// condition for berserker
				if (choicew.getL_warrior().get(a - 1).getName() == "berserker") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					if (choiced.getL_demon().get(b - 1).getHp() == 0) {
						choiced.getL_demon().get(b - 1).setHp(5); // set monster hp to 5
																	// after monster is fainted
						System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " got fainted"
								+ " by " + choicew.getL_warrior().get(a - 1).getName() + " !! hence gets 5 hp back ");
					}
				} else if (choicew.getL_warrior().get(a - 1).getName() != "berserker"
						&& choicew.getL_warrior().get(a - 1).getName() != "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
				}
				break;
			case 4:
				System.out.println("Choose the demon you want to attack: ");
				b = c.nextInt();
				// condition for rogue
				/*
				 * if (choicew.getL_warrior().get(a-1).getName()=="rogue") {
				 * choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
				 * }
				 */
				// condition for rogue
				if (choicew.getL_warrior().get(a - 1).getName() == "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					// choiced.getL_demon().get(b-1).setHp(choiced.getL_demon().get(b-1).getHp()-3);
					index_rogue_attack = b;
					rogue_attack = choiced.getL_demon().get(b - 1).getName();
					rogue_attack_flag = 1;

				}
				// condition for berserker
				if (choicew.getL_warrior().get(a - 1).getName() == "berserker") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
					if (choiced.getL_demon().get(b - 1).getHp() == 0) {
						choiced.getL_demon().get(b - 1).setHp(5); // set monster hp to 5
																	// after monster is fainted
						System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " got fainted"
								+ " by " + choicew.getL_warrior().get(a - 1).getName() + " !! hence gets 5 hp back ");
					}
				} else if (choicew.getL_warrior().get(a - 1).getName() != "berserker"
						&& choicew.getL_warrior().get(a - 1).getName() != "rogue") {
					choiced.getL_demon().get(b - 1).f1(choicew.getL_warrior().get(a - 1).getAttack());
					System.out.println("D " + (b) + ":" + choiced.getL_demon().get(b - 1).getName() + " \t HP="
							+ choiced.getL_demon().get(b - 1).getHp() + "/"
							+ choiced.getL_demon().get(b - 1).getMaxhp());
				}
				break;
			default:
				System.out.println("you didn't Choose the correct warrior index: ");
				break;
			}
			int delay;
			for (int i = 0; i < 10000; i++)
				delay = i;
			for (int i = 0; i < choiced.getL_demon().size(); i++) {
				if (choiced.getL_demon().get(i).getHp() == 0) {
					// choiced.getL_demon_history_faint().add(choicew.getL_warrior().get(i));
					choiced.getL_demon().remove(i);
				}
			}
			for (int i = 0; i < choicew.getL_warrior().size(); i++) {
				if (choicew.getL_warrior().get(i).getHp() == 0) {
					choicew.getL_warrior_history_faint().add(choicew.getL_warrior().get(i));
					choicew.getL_warrior().remove(i);
				}
			}
		}
		// c.close();
	}

	/** The count. */
	int index, count = 0;

	/**
	 * Attack W method chooses a random demon from the l_demon array list
	 * and attack a random warrior from the l_warrior list.
	 */
	public void attackW() {

		if (choiced.getL_demon().isEmpty() == true) {
			level_flag = true;
			// System.out.println(level_flag);
			System.out.println("you cleared this round!! Warriors Won ");
		}
		if (choiced.getL_demon().isEmpty() == false) {
			int a;
			a = (int) (Math.random() * choiced.getL_demon().size());
			String dem = choiced.getL_demon().get(a).getName();
			//System.out.println(choiced.getL_demon().isEmpty());
			//System.out.println(a);
			//System.out.println(dem);
			switch (dem) {
			case "spider": // for (int i=0;i<2;i++)
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
				break;
			case "mummy":
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
				break;
			case "slime":
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
				break;
			case "manticore":
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
				break;
			case "gremlin":
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
				break;
			case "aishwarya":
				if (choiced.getL_demon().get(a).getName() == rogue_attack && rogue_attack_flag == 1
						&& rogue_attack_count < 2) {
					choiced.getL_demon().get(a).setHp(choiced.getL_demon().get(a).getHp() - 3);
					attack_one_warrior(a);
					++rogue_attack_count;
				} else {
					attack_one_warrior(a);
				}
			}
		}
	}

	/**
	 * Attack one warrior - randomly chosen from the l_warrior array list.
	 *
	 * @param a the a is the index of demon here that is passed to attack any warrior
	 */
	public void attack_one_warrior(int a) {
		int b;
		b = (int) (Math.random() * choicew.getL_warrior().size());
		String war2 = choicew.getL_warrior().get(b).getName();
		//System.out.println(b);
		//System.out.println(war2);
		switch (war2) {
		case "monk":
			if (choicew.getL_warrior().get(b).getHp() == choicew.getL_warrior().get(b).getMaxhp() && flag4 == 0) {
				flag4 = 1; // ignore only once
				System.out.println("Monk has dodged " + choiced.getL_demon().get(a).getName() + "attack");
			} else {
				choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
				System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
						+ choicew.getL_warrior().get(b).getName());
			}
			break;
		case "duelist":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;

		case "rogue":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "defender":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName()); // defender gets hit
			System.out.println(
					"Defender retaliates..... and attackes " + choiced.getL_demon().get(a).getName() + " back !!");
			choiced.getL_demon().get(a).f1(choicew.getL_warrior().get(b).getAttack());
			System.out.println("D " + (a) + ":" + choiced.getL_demon().get(a).getName() + " \t HP="
					+ choiced.getL_demon().get(a).getHp() + "/" + choiced.getL_demon().get(a).getMaxhp());
			break;
		case "berserker":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "vishal":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "paladin":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "cleric":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "warrior":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		case "assassin":
			choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
			System.out.println("Demon :" + choiced.getL_demon().get(a).getName() + " attacked "
					+ choicew.getL_warrior().get(b).getName());
			break;
		/*
		 * if (choiced.getL_demon().isEmpty()==false) {
		 * 
		 * choicew.getL_warrior().get(b).f1(choiced.getL_demon().get(a).getAttack());
		 * System.out.println("Demon :"+ choiced.getL_demon().get(a).getName()+
		 * " attacked "+ choicew.getL_warrior().get(b).getName()); }
		 */
		}
		for (int i = 0; i < choiced.getL_demon().size(); i++) {
			if (choiced.getL_demon().get(i).getHp() == 0) {
				// choiced.getL_demon_history_faint().add(choicew.getL_warrior().get(i));
				choiced.getL_demon().remove(i);
			}
		}

		for (int i = 0; i < choicew.getL_warrior().size(); i++) {
			if (choicew.getL_warrior().get(i).getHp() == 0) {
				choicew.getL_warrior_history_faint().add(choicew.getL_warrior().get(i));
				choicew.getL_warrior().remove(i);
			}
		}

	}

	/**
	 * Checkw.
	 * To check if all the warrior are dead or not
	 * @return true, if successful
	 */
	public boolean checkw() { // false means all warriors not dead yet
		int flag = 0;
		for (int i = 0; i < choicew.getL_warrior().size(); i++) {
			if (choicew.getL_warrior().get(i).getHp() == 0)
				continue;
			else {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return false;
		else
			return true;
	}

	/**
	 * Regain.
	 * To regain all warriors health who passed on to level 2 and 3
	 * Those warriors that fainted will get 25% of the max health point of the corresponding warrior 
	 * @param choicew the choicew
	 */
	public void regain(ChoiceW choicew) {
		// int i=0;
		// while(choicew.getL_warrior_history_faint().isEmpty()==true)
		for (int i = 0; i < choicew.getL_warrior_history_faint().size(); i++) {
			choicew.getL_warrior().add(choicew.getL_warrior_history_faint().get(i));
			// choicew.getL_warrior_history_faint().remove(i);
			// i++;
		}
		choicew.getL_warrior_history_faint().clear();
		for (int i = 0; i < choicew.getL_warrior().size(); i++) {
			if (choicew.getL_warrior().get(i).getHp() == 0)
				choicew.getL_warrior().get(i).setHp(choicew.getL_warrior().get(i).getMaxhp() / 4);
			else
				choicew.getL_warrior().get(i).setHp(choicew.getL_warrior().get(i).getMaxhp());
		}
	}

};


