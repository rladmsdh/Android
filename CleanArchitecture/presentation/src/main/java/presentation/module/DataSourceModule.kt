package presentation.module

import com.example.data.data.datasource.LoginDataSource
import com.example.data.data.datasource.LoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideUserDataSource(
        userDataSourceImpl: LoginDataSourceImpl,
    ): LoginDataSource
}