package com.sanket.assignment

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.sanket.assignment.models.response.UserResponse
import com.sanket.assignment.repository.MainRepository
import com.sanket.assignment.retrofit.RetrofitClient
import com.sanket.assignment.retrofit.UserApi
import com.sanket.assignment.utils.NetworkResult
import com.sanket.assignment.viewmodels.MainViewModel
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Callable


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {


}