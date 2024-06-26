package src.Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import src.Help.CardPlants.CardPlant;
import src.Help.LawnMower.LawnMower;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.SunDrop.DropSun;
import src.Model.Characters.Zombies.Zombie;

public class GameData implements Serializable {
// Var
    @Serial
    private static final long serialVersionUID = 1L;

    private int ID;
    private List<CardPlant> cardPlantList = null;
    private List<Plant> listPlant = null;
    private List<Zombie> zombieAlive = null;
    private List<ZombieSpawner> zombieSpawner = null;
    private List<LawnMower> lawnMowers = null;
    private DropSun dropSun = null;
    private int sun = 0;
    private int tick = 0;
    private int sumZombie = 0;
    private List<Double> listPercentFlag;
// Construct
    public GameData() {
        super();
        this.cardPlantList = new ArrayList<CardPlant>();
        this.listPlant = Collections.synchronizedList(new ArrayList<Plant>()); // Xử dụng Collections.synchronizedList để đồng bộ dữ liệu 
        this.zombieAlive = Collections.synchronizedList(new ArrayList<Zombie>());
        this.zombieSpawner = Collections.synchronizedList(new ArrayList<ZombieSpawner>());
        this.lawnMowers = new ArrayList<LawnMower>();
        this.dropSun = new DropSun();
        this.listPercentFlag = new ArrayList<Double>();
    }
    public GameData(List<CardPlant> cardPlantList, List<Plant> listPlant, List<Zombie> zombieAlive
            , List<ZombieSpawner> zombieSpawner, List<LawnMower> lawnMowers, int sun, int tick) {
        super();
        this.cardPlantList = cardPlantList;
        this.listPlant = listPlant;
        this.zombieAlive = zombieAlive;
        this.zombieSpawner = zombieSpawner;
        this.sun = sun;
        this.tick = tick;
        this.lawnMowers = lawnMowers;
        this.dropSun = new DropSun();

        this.listPercentFlag = new ArrayList<Double>();

        loadDataAfterInit();
    }

    // Thêm cây
    public void addPlant(Plant p) {
        listPlant.add(p);
    }

    // Xoá cây
    public void remotePlant(Plant p) {
        listPlant.remove(p);
    }

    // Thêm Zombie vào game
    public void addZombieAlive(Zombie z) {
        zombieAlive.add(z);
    }

    // Xoá Zombie tồn tại - Zombie chết
    public void remoteZombieAlive(Zombie z) {
        zombieAlive.remove(z);
    }

    // Thêm Zombie vào hàng đợi
    public void addZombieSpawner(ZombieSpawner z) {
        zombieSpawner.add(z);
    }

    // Xoá Zombie hàng đợi
    public void remoteZombieSpawner(ZombieSpawner z) {
        zombieSpawner.remove(z);
    }

    // Lấy ra tổng số Zombie
    private void loadSumZombie() {
        this.sumZombie = zombieAlive.size() + zombieSpawner.size();
    }

    // creat list percent flag
    private void creatListPercentFlag() {
        for (int i = 0; i < sumZombie; i++) {
            ZombieSpawner z = zombieSpawner.get(i);
            if ((z.getNameZombie().toUpperCase())
                    .equalsIgnoreCase("FLAGZOMBIE")
            ) {
                listPercentFlag.add(
                        (double) (i + 1) / sumZombie
                );
            }
        }
    }

    // LoadData after init
    public void loadDataAfterInit() {
        loadSumZombie();
        creatListPercentFlag();
    }

    // To String
    @Override
    public String toString() {
        return "GameData{" +
                "ID=" + ID +
                ", cardPlantList=" + cardPlantList +
                ", listPlant=" + listPlant +
                ", zombieAlive=" + zombieAlive +
                ", zombieSpawner=" + zombieSpawner +
                ", lawnMowers=" + lawnMowers +
                ", dropSun=" + dropSun +
                ", sun=" + sun +
                ", tick=" + tick +
                ", sumZombie=" + sumZombie +
                '}';
    }

    // Getter and setter
    public List<Plant> getListPlant() {
        return listPlant;
    }
    public void setListPlant(List<Plant> listPlant) {
        this.listPlant = listPlant;
    }
    public List<Zombie> getZombieAlive() {
        return zombieAlive;
    }
    public void setZombieAlive(List<Zombie> zombieAlive) {
        this.zombieAlive = zombieAlive;
    }
    public List<ZombieSpawner> getZombieSpawner() {
        return zombieSpawner;
    }
    public void setZombieSpawner(List<ZombieSpawner> zombieSpawner) {
        this.zombieSpawner = zombieSpawner;
    }
    public int getSun() {
        return sun;
    }
    public void setSun(int sun) {
        this.sun = sun;
    }
    public int getTick() {
        return tick;
    }
    public void setTick(int tick) {
        this.tick = tick;
    }
    public List<CardPlant> getCardPlantList() {
        return cardPlantList;
    }

    public void setCardPlantList(List<CardPlant> cardPlantList) {
        this.cardPlantList = cardPlantList;
    }

    public DropSun getDropSun() {
        return dropSun;
    }
    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    public int getSumZombie() {
        return sumZombie;
    }

    public void setSumZombie(int sumZombie) {
        this.sumZombie = sumZombie;
    }

    public List<LawnMower> getLawnMowers() {
        return lawnMowers;
    }

    public void setLawnMowers(List<LawnMower> lawnMowers) {
        this.lawnMowers = lawnMowers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Double> getListPercentFlag() {
        return listPercentFlag;
    }

    public void setListPercentFlag(List<Double> listPercentFlag) {
        this.listPercentFlag = listPercentFlag;
    }
}
