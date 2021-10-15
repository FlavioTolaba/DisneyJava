package com.disneyApp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Serie")
public class Serie extends EShow {

}
