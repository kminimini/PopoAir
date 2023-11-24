package com.popo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParkInfo is a Querydsl query type for ParkInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParkInfo extends EntityPathBase<ParkInfo> {

    private static final long serialVersionUID = -1464773025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParkInfo parkInfo = new QParkInfo("parkInfo");

    public final StringPath aprEng = createString("aprEng");

    public final StringPath aprKor = createString("aprKor");

    public final QMember member;

    public final StringPath parkingAirportCodeName = createString("parkingAirportCodeName");

    public final NumberPath<Integer> parkingFullSpace = createNumber("parkingFullSpace", Integer.class);

    public final StringPath parkingGetdate = createString("parkingGetdate");

    public final StringPath parkingGettime = createString("parkingGettime");

    public final NumberPath<Integer> parkingIincnt = createNumber("parkingIincnt", Integer.class);

    public final NumberPath<Integer> parkingIoutcnt = createNumber("parkingIoutcnt", Integer.class);

    public final NumberPath<Integer> parkingIstay = createNumber("parkingIstay", Integer.class);

    public QParkInfo(String variable) {
        this(ParkInfo.class, forVariable(variable), INITS);
    }

    public QParkInfo(Path<? extends ParkInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParkInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParkInfo(PathMetadata metadata, PathInits inits) {
        this(ParkInfo.class, metadata, inits);
    }

    public QParkInfo(Class<? extends ParkInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

