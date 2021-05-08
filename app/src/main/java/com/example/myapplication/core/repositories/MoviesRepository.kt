package com.example.myapplication.core.repositories

import com.example.myapplication.core.exception.Failure
import com.example.myapplication.core.functional.Either
import com.example.myapplication.core.platform.NetworkHandler
import com.example.myapplication.core.services.MoviesService
import com.example.myapplication.models.Movie
import com.example.myapplication.core.exception.Failure.NetworkConnection
import com.example.myapplication.core.exception.Failure.ServerError
import retrofit2.Call
import javax.inject.Inject

interface MoviesRepository {

    fun movies(): Either<Failure, List<Movie>>

    class Network
    @Inject constructor(
            private val networkHandler: NetworkHandler,
            private val service: MoviesService
    ) : MoviesRepository {

        override fun movies(): Either<Failure, List<Movie>> {

            /* Two specific Scenarios::
             * SCENARIO-1: There can be Network connection available
             * SCENARIO-2: There might not be Network connection available
             * */
            return when (networkHandler.isNetworkAvailable()) {

                // SCENARIO-1: There can be Network connection available -> Call the server end point
                true -> {
                    val response = service.movies().execute()
                    /* Two specific Scenarios::
                    * SCENARIO-1: A Response can be successful
                    * SCENARIO-2: A Response can be un-successful
                    * */
                    when (response.isSuccessful) {

                        // SCENARIO-1: A Response can be successful

                        /* Two sub-specific Scenarios::
                        * SUB-SPECIFIC-SCENARIO-1: A Response can be successful and has a body - > Return the body
                        * SUB-SPECIFIC-SCENARIO-2: A Response can be successful but no body - > Return the empty list
                        * */

                        true -> Either.Right(response.body() ?: emptyList())

                        // SCENARIO-2: A Response can be un-successful - > Return Server error
                        false -> Either.Left(ServerError)
                    }
                }

                // SCENARIO-2: There might not be Network connection available -> Return network error
                false -> Either.Left(NetworkConnection)
            }
        }

    }

}