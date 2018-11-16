package id.kotlin.android.features.detail

import com.nhaarman.mockitokotlin2.verify
import id.kotlin.android.features.home.Movie
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest {

    @Mock private lateinit var view: DetailView
    @Mock private lateinit var movie: Movie

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        presenter = DetailPresenter()
        presenter.onAttach(view)
    }

    @Test
    fun `Should return movie detail`() {
        presenter.showMovie(movie)
        verify(view).onShowMovie(movie)
    }
}