package src.Model.ActCharacter.Plant;

import src.Config.Config;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.Characters.Plants.SunDrop.DropSun;
import src.Utils.LaneToLayoutY;

public class ActDropSun implements Act {
    // Var
    private DropSun dropSun;

    // Constructor
    public ActDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    // Method Implement
    @Override
    public void move() {

    }

    @Override
    public void attack(Object object) {

    }

    // Tạo ra 1 sun rơi từ trên xuống vị trí ngẫu nhiên
    @Override
    public void handle() {

        int x = Config.getRandom().nextInt(665) + 320;
        int lane = Config.getRandom().nextInt(5);

        Sun sun = new Sun(x, 0, lane, x, LaneToLayoutY.sunGetLayoutY(lane)
                , dropSun.getTimeOut(), dropSun.getDy(), dropSun.getTimeKeyFrame()
                , dropSun.getListSun());
        synchronized (dropSun.getListSun()) {
            sun.start2();
            dropSun.getListSun().add(sun);
        }
    }

    // Getter
    public DropSun getDropSun() {
        return dropSun;
    }

    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }
}