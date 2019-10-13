package main.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sources")
public class Source
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String description;
    @Column(unique = false, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sources")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "sourced_attached_skills",
    joinColumns = @JoinColumn(name = "source_id"),
    inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skillList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}
