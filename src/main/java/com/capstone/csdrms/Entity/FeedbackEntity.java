package com.capstone.csdrms.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblfeedback")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackID")
    private int fid;

    @Column(name = "aid")
    private int aid;

    @Column(name = "sanction_id")
    private int sanction_id;

    @Column(name = "isAcknowledged")
    private int isAcknowledged;

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "aid", insertable = false, updatable = false)
    private AdviserEntity adviser;

    @ManyToOne
    @JoinColumn(name = "sanction_id", insertable = false, updatable = false)
    private SanctionEntity sanction;

    public FeedbackEntity() {
        super();
    }

    public FeedbackEntity(int fid, int aid, int sanction_id, int isAcknowledged) {
        super();
        this.fid = fid;
        this.aid = aid;
        this.sanction_id = sanction_id;
        this.isAcknowledged = isAcknowledged;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getSanction_id() {
        return sanction_id;
    }

    public void setSanction_id(int sanction_id) {
        this.sanction_id = sanction_id;
    }

    public int getIsAcknowledged() {
        return isAcknowledged;
    }

    public void setIsAcknowledged(int isAcknowledged) {
        this.isAcknowledged = isAcknowledged;
    }

    public AdviserEntity getAdviser() {
        return adviser;
    }

    public void setAdviser(AdviserEntity adviser) {
        this.adviser = adviser;
    }

    public SanctionEntity getSanction() {
        return sanction;
    }

    public void setSanction(SanctionEntity sanction) {
        this.sanction = sanction;
    }
}
