package com.test.task.utils;

import static com.test.task.enums.filterpanel.ButtonName.BATHROOMS;
import static com.test.task.enums.filterpanel.ButtonName.BEDROOMS;
import static com.test.task.enums.filterpanel.ButtonName.BEDS;
import static com.test.task.enums.filterpanel.CheckBoxName.AIR_CONDITIONING;
import static com.test.task.enums.filterpanel.CheckBoxName.BEACH_FRONT;
import static com.test.task.enums.filterpanel.CheckBoxName.FREE_WIFI;
import static com.test.task.enums.filterpanel.CheckBoxName.HOT_TUBE;
import static com.test.task.enums.filterpanel.CheckBoxName.KITCHEN;
import static com.test.task.enums.filterpanel.CheckBoxName.PETS_ALLOWED;
import static com.test.task.enums.filterpanel.CheckBoxName.STREET_PARKING;
import static com.test.task.enums.filterpanel.CheckBoxName.SUITABLE_FOR_CHILDREN;
import static com.test.task.enums.filterpanel.CheckBoxName.SWIMMING_POOL;
import static com.test.task.enums.filterpanel.CheckBoxName.WASHING_MACHINE;

import com.test.task.enums.filterpanel.ButtonName;
import com.test.task.enums.filterpanel.CheckBoxName;
import java.util.List;
import java.util.Random;

public final class RandomUtils {

    public static CheckBoxName getRandomCheckBox() {
        List<CheckBoxName> checkboxes =
            List.of(AIR_CONDITIONING, BEACH_FRONT, FREE_WIFI, PETS_ALLOWED, STREET_PARKING, SWIMMING_POOL, KITCHEN,
                WASHING_MACHINE, HOT_TUBE, SUITABLE_FOR_CHILDREN);
        int index = new Random().nextInt(checkboxes.size());
        return checkboxes.get(index);
    }

    public static ButtonName getRandomButton() {
        List<ButtonName> buttonNames = List.of(BEDS, BEDROOMS, BATHROOMS);
        int index = new Random().nextInt(buttonNames.size());
        return buttonNames.get(index);
    }
}
