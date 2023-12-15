package com.popo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFlight is a Querydsl query type for Flight
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFlight extends EntityPathBase<Flight> {

    private static final long serialVersionUID = 772350167L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFlight flight = new QFlight("flight");

    public final StringPath airline = createString("airline");

    public final StringPath airlineNm = createString("airlineNm");

    public final StringPath arrAirportNm = createString("arrAirportNm");

    public final NumberPath<Long> arrPlandTime = createNumber("arrPlandTime", Long.class);

    public final StringPath depAirportNm = createString("depAirportNm");

    public final NumberPath<Long> depPlandTime = createNumber("depPlandTime", Long.class);

    public final NumberPath<Integer> economyCharge = createNumber("economyCharge", Integer.class);

    public final StringPath endPN_ko = createString("endPN_ko");

    public final StringPath endPortName = createString("endPortName");

    public final QMember member;

    public final NumberPath<Integer> pageNo = createNumber("pageNo", Integer.class);

    public final NumberPath<Integer> prestigeCharge = createNumber("prestigeCharge", Integer.class);

    public final StringPath startDate = createString("startDate");

    public final StringPath startPortName = createString("startPortName");

    public final NumberPath<Integer> totalCount = createNumber("totalCount", Integer.class);

    public final StringPath vihicleId = createString("vihicleId");

    public QFlight(String variable) {
        this(Flight.class, forVariable(variable), INITS);
    }

    public QFlight(Path<? extends Flight> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFlight(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFlight(PathMetadata metadata, PathInits inits) {
        this(Flight.class, metadata, inits);
    }

    public QFlight(Class<? extends Flight> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

