package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.BaseEntity;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistBeginDate;
import org.nanotek.beans.entity.ArtistComment;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.ArtistEndDate;
import org.nanotek.beans.entity.ArtistSortName;
import org.nanotek.beans.entity.ArtistType;
import org.nanotek.beans.entity.Gender;
import org.nanotek.beans.entity.MutableGenderEntity;
import org.nanotek.collections.AritistCreditStreamableEntity;

public interface BaseArtistEntity<K extends Serializable> extends 
BaseEntity,
MutableArtistIdEntity<Long>,
AritistCreditStreamableEntity<ArtistCredit<?>>,
MutableArtistSortNameEntity<ArtistSortName<?>>,
MutableArtistCommentEntity<ArtistComment<?>>,
MutableArtistBeginDateEntity<ArtistBeginDate>,
MutableArtistEndDateEntity<ArtistEndDate>,
MutableArtistTypeEntity<ArtistType<Artist<?>>>,
MutableGenderEntity<Gender>,
MutableAreaEntity<Area<Artist<?>>>,
MutableArtistBeginAreaEntity<Area<Artist<?>>>{

}
