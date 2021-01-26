package fr.blueberry.studio.hermes.api.jobs;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;

/**
 * Job
 */
public interface Job {
    
    /**
     * Run the job.
     */
    public void run();

    /**
     * Get Hermes application.
     * @return - Hermes app
     */
    public Hermes getHermes();

    /**
     * Get the logger of the application.
     * @return - The logger of the application.
     */
    public Logger getLogger();
}
