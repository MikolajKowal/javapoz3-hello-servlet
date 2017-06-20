package com.sda.todo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class TodoMapper {

    public static TodoModel map(HttpServletRequest req) {

        Map <String, String[]> map = req.getParameterMap();
        TodoModel model = new TodoModel();
        model.setName(map.get("name")[0]);
        model.setDescription(map.get("description")[0]);
        model.setChecked(getChecked(map));
        model.setPriority(getPriority(map));
        model.setDate(getDate(map));
        return model;
    }

    public static String map(TodoModel todoModel){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(todoModel.getName() + "\r\n")
                .append(todoModel.getDescription() + "\r\n")
                .append(String.valueOf(todoModel.isChecked()) + "\r\n")
                .append(todoModel.getPriority() + "\r\n")
                .append(todoModel.getDate() + "\r\n")
                .toString();

    }

    public static TodoModel map(Scanner scanner){
        return map(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
    }

    public static TodoModel map(String title, String description, String status, String priority, String date ){
        TodoModel model = new TodoModel();
        model.setName(title);
        model.setDescription(description);
        model.setChecked("true".equals(status));
//      model.setChecked(new Boolean(status)); - taka wersja też może być, efektywnie otrzymamy to samo,
        // model.setChecked(Boolean.valueOf(status));
        model.setPriority(Integer.parseInt(priority));
        model.setDate(LocalDate.parse(date));
        return model;
    }

    private static LocalDate getDate(Map<String, String[]> map) {
        String dateAsString = map.get("date")[0];
        String[] split = dateAsString.split("-");
        return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private static int getPriority(Map<String, String[]> map) {
        return Integer.parseInt(map.get("priority")[0]);
    }

    private static boolean getChecked(Map<String, String[]> map) {
        return map.containsKey("checked");
    }
}
