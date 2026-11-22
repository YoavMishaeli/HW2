package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collectibles;
	private int count;
	//       - an array of Collectibles (it may be larger than the number of items actually stored)
	//       - an int that counts how many items are actually stored

	public NaiveInventory() {
		collectibles = new Collectible[INITIAL_CAPACITY];
		count = 0;
	}

	@Override // Adds a collectible to our inventory
	public void collect(Collectible collectible) {
		if (count == collectibles.length){
			Collectible[] tempCollectibles = new Collectible[(collectibles.length) * 2];
			for (int i = 0; i < collectibles.length; i++){
				tempCollectibles[i] = collectibles[i];
			}
			collectibles = tempCollectibles;
		}
		collectibles[count] = collectible;
		count++;
	}

	@Override// Returns combined weight of all items in the inventory
	public float getTotalWeight() {
		float totalWeight = 0.0f;
		for (int i = 0; i< count; i++){
			totalWeight += collectibles[i].getWeight();
		}
		return totalWeight;
	}

	@Override // Returns the amount of items in the inventory 
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
