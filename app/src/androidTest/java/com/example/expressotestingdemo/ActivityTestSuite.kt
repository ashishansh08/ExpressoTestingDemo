package com.example.expressotestingdemo

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 ** Use to bundle up the test classes together so that you do not have to go and run each and every test class separately
 **/

@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class, SecondaryActivityTest::class)
class ActivityTestSuite