package at.km.fsbackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Size(min = 3)
        private String text;

        @ManyToOne
        @JsonIgnore
        private Post post;
    }


