package ch.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{
        private static final long serialVersionUID = 8072966150998268844L;
        
        @Id
        @GeneratedValue
        private int id;
        
        @Column(name="NAME")
        private String name;
        
        @Column(name="RECORD")
        private int record;
        
        public Student(){
                
        }
        
        public Student(int id, String name, int record) {
                super();
                this.id = id;
                this.name = name;
                this.record = record;
        }

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

        public int getRecord() {
                return record;
        }

        public void setRecord(int record) {
                this.record = record;
        }

        @Override
        public String toString() {
                return "Student [id=" + id + ", name=" + name + ", record=" + record + "]";
        }

}