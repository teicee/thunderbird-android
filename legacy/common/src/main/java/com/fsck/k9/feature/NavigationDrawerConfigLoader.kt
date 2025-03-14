package com.fsck.k9.feature

import app.k9mail.feature.navigation.drawer.NavigationDrawerExternalContract.DrawerConfig
import app.k9mail.feature.navigation.drawer.NavigationDrawerExternalContract.DrawerConfigLoader
import com.fsck.k9.preferences.DrawerConfigManager
import kotlinx.coroutines.flow.Flow

class NavigationDrawerConfigLoader(private val drawerConfigManager: DrawerConfigManager) : DrawerConfigLoader {
    override fun loadDrawerConfigFlow(): Flow<DrawerConfig> {
        return drawerConfigManager.getConfigFlow()
    }
}
