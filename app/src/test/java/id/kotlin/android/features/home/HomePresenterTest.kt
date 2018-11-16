package id.kotlin.android.features.home

import com.nhaarman.mockitokotlin2.KArgumentCaptor
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import id.kotlin.android.core.domain.DefaultObserver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest {

    @Mock private lateinit var usecase: HomeUsecase
    @Mock private lateinit var params: HomeParam
    @Mock private lateinit var view: HomeView
    @Mock private lateinit var entity: HomeEntity

    private lateinit var presenter: HomePresenter
    private lateinit var captor: KArgumentCaptor<DefaultObserver<HomeEntity>>

    @Before
    fun setUp() {
        captor = argumentCaptor()
        presenter = HomePresenter(usecase)
        presenter.onAttach(view)
    }

    @Test
    fun `Should return list of movie`() {
        presenter.discoverMovie(params)
        verify(view).onShowLoading()
        verify(usecase).execute(captor.capture(), eq(params))
        captor.firstValue.onSuccess(entity)
        verify(view).onShowDiscoverMovie(entity)
    }

    @Test
    fun `Should return failed when retrieving list of movie`() {
        val message = "Something went wrong!"
        presenter.discoverMovie(params)
        verify(view).onShowLoading()
        verify(usecase).execute(captor.capture(), eq(params))
        captor.firstValue.onError(Exception(message))
        verify(view).onShowErrorMessage(eq(message))
    }

    @After
    fun tearDown() {
        usecase.dispose()
    }
}