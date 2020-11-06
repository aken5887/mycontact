package com.ardent.springboot.project3.mycontact.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
/** @Data 대체 가능 **/
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    private String address;

    @NonNull
    private String bloodType;

    private LocalDate birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;
    /**
     * relation
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude   /* 불필요한 쿼리 호출 줄임 */
    private Block block;
}
