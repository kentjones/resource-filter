package com.kent.jones.atomic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ LoadResourceTest.class, AtomicEqualAndGreaterPredicateTest.class, AtomicLessThanPredicateTest.class, AtomicEqualPredicateTest.class, AtomicGreaterThanPredicateTest.class })

public class RunAtomicTests {}
