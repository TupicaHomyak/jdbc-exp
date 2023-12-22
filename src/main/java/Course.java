import jakarta.persistence.*;

@Entity // аннотации, чтобы джава корректно искала таблицу
@Table(name = "Courses") //имя таблицы в бд
public class Course {

    @Id // у поля айди должна быть обязательна эта аннотация
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автомат.инкрементир.значение
    private int id;

    private String name;
    private int duration;

    @Enumerated(EnumType.STRING) // помогаем работать енамам
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

    //поля, которые названы не так, как в базе данных тоже надо обозначить:
    @Column(name = "teacher_id")
    private int teacherId;
    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    //геттеры и сеттеры далее:

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }
    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentsCount() {
        return studentsCount;
    }
    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
