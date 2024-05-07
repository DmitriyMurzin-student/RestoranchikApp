package com.example.restoanchik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import com.example.restoanchik.data.database.GetTableDatabase;
import com.example.restoanchik.data.model.RestaurantModel;
import com.example.restoanchik.data.repository.DatabaseRepository;

public class MainActivity extends AppCompatActivity {
    private DatabaseRepository databaseRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создаем или получаем уже созданный singleton-экземпляр базы данных
        GetTableDatabase database = GetTableDatabase.getInstance(this);

        // Инициализируем экземпляр DatabaseRepository с реальным экземпляром БД
        databaseRepository = new DatabaseRepository(database);

        // Если вам нужно очистить все данные перед добавлением новых,
        // вызовем метод deleteAll() для очистки базы данных
        databaseRepository.deleteAllAsync();

        // Теперь можно добавить mock данные в БД
        addMockRestaurantsToDB();
    }
    private void addMockRestaurantsToDB() {
        databaseRepository.insertRestaurantsAsync(
                new RestaurantModel(
                        1,
                        "SFC-Chicken-Цыплята по-английски\n",
                        "sfc-chicken",
                        "Геофизиков, 6 ТЦ Добрыня, Краснокамск 617060 Россия",
                        "12:00–00:00",
                        "Итальянская, Морепродукты, Средиземноморская, Европейская, Русская, Центральноевропейская, Международная"
                ),
                new RestaurantModel(
                        2,
                        "Кедровый дом",
                        "kedrdom",
                        "Гагарина, 150в, Краснокамск 617076 Россия",
                        "00:00–00:00",
                        "Международная"
                ),
                new RestaurantModel(
                        3,
                        "Наири",
                        "nairi",
                        "Советская, 67, Пермь 614000 Россия",
                        "09:00–00:00",
                        "Бельгийская, Русская, Восточноевропейская, Европейская"
                ),
                new RestaurantModel(
                        4,
                        "\"Булка\" кафе-пекарня",
                        "bulka",
                        " Энтузиастов, 5, Краснокамск 617060 Россия",
                        "00:00–23:00",
                        "Европейская, Итальянская, Средиземноморская"
                ),
                new RestaurantModel(
                        5,
                        "Valery",
                        "valery",
                        "Большевистская, 41, Краснокамск 617060 Россия",
                        "11:00–01:00",
                        "Бар, Паб, Пивные рестораны"
                )
        );
    }
}