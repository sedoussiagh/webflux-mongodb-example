package org.webflux.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item")
public class Item {
    private Integer id;
    private String name;

}
